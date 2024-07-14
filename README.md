# Job Normalization API

This API normalizes job names based on a list of supported normalized names.
Currently, the supported normalized job names are: `Software engineer`, `Accountant`, `Architect`, and `Quantity surveyor`.

## API Endpoints

Currently, the only endpoint is the `POST /normalize`.

To manually test the endpoint, you can use the below `curl` command.

(have a look at the Running Locally section to see how to bootstrap the server locally*)

```bash
curl -X POST 'http://localhost:8080/job-normalizer/v1/normalize' \
  -H 'Content-Type: application/json' \
  -d '{"jobName":"java engineer"}'
```

## Documentation

The documentation files are stored in the `docs` folder.

### OpenAPI Specification

An OpenAPI specification is available at `/docs/openapi.yaml` and can be rendered using Swagger.

### Sequence Diagrams

All the sequence diagrams below are available at `/docs/diagrams/` in `png` format.

#### User - API sequence

![User - API sequence](docs/diagrams/Sequence%20User-API%20interaction.png)

#### Classes sequence

![Classes sequence](docs/diagrams/Sequence%20classes%20interaction.png)

## Running Locally

Follow the below instructions to bootstrap the server locally.

### JDK & Maven

This is a Maven-managed project. See the table below for the JDK and Maven versions required to properly run the server.

| Dependency | Version |
|------------|---------|
|JDK         |`17^`    |
|Maven       |`4.0.0^` |

### Installing Dependencies & Compiling The Code

To install dependencies and compile the code, use one of the following commands:

```bash
mvn clean install
```

```bash
make install
```

### Running Tests

To run the unit tests, use one of the following commands:

```bash
mvn test
```

```bash
make test
```

### Running The Server

To run the server locally, use one of the following commands:

```bash
mvn spring-boot:run
```

```bash
make run-server
```

(Remember that the default server port is `8080`*)

## Decisions & Consequences

1.  Levenshtein Distance Algorithm

There are two good implementations for calculating the Levenshtein distance. One, using a recursive function, and another using an array.

I decided to go with the array option because it is faster and easier for a human to understand and debug.

Despite being faster, the array consumes significantly more memory, but nowadays memory is not a big issue, while performance is still strongly relevant.

In short, this the key points behind the decision were `performance` and `maintainability`.

2.  Security: No authorization

This API acts as a library, it does not interact, produce or consume any private data. Therefore, no session or access token is required for security.

3.  Not implement the Job Normalization in the NormalizerUtil class

I decided not to implement anything related to the specific API use case in the NormalizerUtil class. 

The sole responsibility of this class is to provide utility functions to normalize any string, while the specific use case of job name normalization is considered a responsibility of the NormalizationService class.

## Future Improvements

1.  Docker image

Ideally in the future, a docker image of this service should be made to run it inside a docker container.

2.  Context path

I defined `/job-normalizer/v1` as the context path for the server. 

However, considering that this API should be part of a microservices architecture, this context path should be defined in an API Gateway or reverse proxy instead.
