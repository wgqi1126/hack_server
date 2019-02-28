RED='\033[0;31m'
NC='\033[0m' # No Color

cd $(dirname $0)

echo "${RED}Type \"111111\" when you need input pass.${NC}"
echo "${RED}Type \"Enter\" when you need input other info.${NC}"

# generate root private key
openssl genrsa -des3 -out root.key 2048

# generate a root certificate
openssl req -x509 -new -nodes -key root.key -sha256 -days 1825 -out root.pem
