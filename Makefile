APP= paypal-service-v1
PORT=8085
CERT_FOLDER=cert

docker-local: env
	echo "[1/4] Maven: clean and package"
	mvn clean package -B
	echo "[2/4] Docker: build"
	docker build -t ${APP} .
	echo "[3/4] Docker: stoping container (if exists)"
	docker stop ${APP} || true && docker rm ${APP} || true
	echo "[4/4] Docker: running Container"
	docker run -v ${PWD}/${CERT_FOLDER}:/cert \
		-e USERNAME=${PAYPAL_USERNAME} \
		-e PASSWORD=${PAYPAL_PASSWORD} \
		-e SIGNATURE=${PAYPAL_SIGNATURE} \
		-p ${PORT}:8080 ${APP}

env:
	echo "Username: ${PAYPAL_USERNAME}"

curl:
	curl http://localhost:${PORT}/setExpressCheckout \
		-H "Content-Type: application/json" \
		-d '{"username" : "Gonzalo"}'
        

