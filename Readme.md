## Rest API using Spring Boot GraphQL

## Run
    mvn spring-boot:run

## Example all Books
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

# Example Book API
    curl -X POST \
      http://localhost:8091/rest/books \
      -H 'Accept: */*' \
      -H 'Cache-Control: no-cache' \
      -H 'Connection: keep-alive' \
      -H 'Content-Type: text/plain' \
      -H 'Host: localhost:8091' \
      -H 'Postman-Token: 703a185b-d6e2-4c97-9b1e-f43d589b254a,7e43277b-4bab-4747-828a-fc08bf7a0414' \
      -H 'User-Agent: PostmanRuntime/7.13.0' \
      -H 'accept-encoding: gzip, deflate' \
      -H 'cache-control: no-cache' \
      -H 'content-length: 52' \
      -d '{
    	book (id:"978-1542040464"){
    	title,
    	authors
    	}
    }'
