## Rest API using Spring Boot GraphQL


## Example
    curl -X POST \
      http://localhost:8091/rest/books \
      -H 'Accept: */*' \
      -H 'Cache-Control: no-cache' \
      -H 'Connection: keep-alive' \
      -H 'Content-Type: text/plain' \
      -H 'Host: localhost:8091' \
      -H 'Postman-Token: 5f266a78-ef55-45d6-8589-60039059d7d6,f1851e2b-259b-4881-84a1-99e6ea2f2d0b' \
      -H 'User-Agent: PostmanRuntime/7.13.0' \
      -H 'accept-encoding: gzip, deflate' \
      -H 'cache-control: no-cache' \
      -H 'content-length: 33' \
      -d '{
    	allBooks {
    		isn,
    		title
    	}
    }'
