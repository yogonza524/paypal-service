APP= paypal-service-v1
CERT_FOLDER=cert

docker-local:
	mvn clean package -B
	docker build -t ${APP} .
	docker stop ${APP} || true && docker rm ${APP} || true
	docker run -v ${PWD}/${CERT_FOLDER}:/cert \
		-e USERNAME=${PAYPAL_USERNAME} \
		-e PASSWORD=${PAYPAL_PASSWORD} \
		-e SIGNATURE=${PAYPAL_SIGNATURE} \
		-p 8085:8080 ${APP}
