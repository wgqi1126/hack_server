# https://deliciousbrains.com/ssl-certificate-authority-for-local-https-development/

RED='\033[0;31m'
YELLOW='\033[0;32m'
NC='\033[0m' # No Color

cd $(dirname $0)

echo "${YELLOW}You can change or add domain in domain.ext${NC}"
echo "${RED}Type \"111111\" when you need input pass (except \"A challenge password []:\").${NC}"
echo "${RED}Type \"Enter\" when you need input other info.${NC}"

cd $(dirname $0)

# create a private key for site
openssl genrsa -out domain.key 2048

# create a csr
openssl req -new -key domain.key -out domain.csr


# create the certificate
openssl x509 -req -in domain.csr -CA root.pem -CAkey root.key -CAcreateserial \
    -out domain.crt -days 1825 -sha256 -extfile domain.ext

openssl pkcs12 -export -in domain.crt -inkey domain.key -out domain.pfx \
    -name tomcat -CAfile domain.crt -caname root
