#!/bin/bash
echo -n "Username: "
read USERNAME
echo -n "Password: "
read -s PASSWORD
echo -e "\nSignature: "
read -s SIGNATURE

export PAYPAL_USERNAME=$USERNAME
export PAYPAL_PASSWORD=$PASSWORD
export PAYPAL_SIGNATURE=$SIGNATURE