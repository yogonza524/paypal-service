#!/bin/bash

echo $(curl --cert cert/$PAYPAL_USERNAME.cert -s --insecure -d USER=$PAYPAL_USERNAME -d PWD=$PAYPAL_PASSWORD -d METHOD=SetExpressCheckout -d VERSION=${PAYPAL_VERSION} -d AMT=10 -d cancelUrl=https://example.com/cancel -d returnUrl=https://example.com/success https://api.sandbox.paypal.com/nvp)