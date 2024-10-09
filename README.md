# Benchmark SingleThread, MultiThread, Reactive

[![Java](https://img.shields.io/badge/java-22.0.2-blue.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/spring--boot-v3.3.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Gatling](https://img.shields.io/badge/gatling-3.2.1-orange.svg)](https://gatling.io/)
[![Scala](https://img.shields.io/badge/scala-2.12-red.svg)](https://www.scala-lang.org/)
[![Docker](https://img.shields.io/badge/docker-27.0.3-2396ED.svg)](https://www.docker.com/)
[![GitHub](https://img.shields.io/badge/github-repo-success.svg)](https://github.com/LucasHenriqueSZ/APIBenchmark-SingleThread-MultiThread-Reactive)

## Description

APIBench-MultiThread-VS-SingleThread-VS-Reactive is a benchmarking project that compares the performance of Java/Spring
APIs using three different approaches: multithreading, single-threading, and reactive programming. The project utilizes
Gatling to test and generate comparative insights about performance.

## Technologies Used

- **Java:** The primary programming language for developing the APIs.
- **Spring Boot:** Framework used for building the APIs and selected for conducting performance tests.
- **Docker:** Used for containerizing the APIs, allowing them to run in isolated and consistent environments.
- **Gatling:** Tool chosen for performance testing, enabling the simulation of user loads, measuring the efficiency of
  the APIs, and generating detailed benchmark test results.
- **Scala:** Language used to create test simulations in Gatling.

## File Structure

    APIBenchmark-SingleThread-MultiThread-Reactive/
    ├── api-singlethreaded/                         # Single-Threaded API module
    │   ├── src/                                    # Source code of the API
    │   ├── Dockerfile                              # Docker configuration file
    │   └── ...                                     # Other files and directories
    ├── api-multithreading/                         # Multi-Threaded API module
    │   ├── src/                                    # Source code of the API
    │   ├── Dockerfile                              # Docker configuration file
    │   └── ...                                     # Other files and directories
    ├── api-reactive/                               # Reactive API module
    │   ├── src/                                    # Source code of the API
    │   ├── Dockerfile                              # Docker configuration file
    │   └── ...                                     # Other files and directories
    ├── gatling/                                    # Directory for Gatling configurations and results
    │   ├── results/                                # Results generated from the benchmark test
    │   │   ├── ...                                 # Other result files
    │   ├── simulations/                            # Gatling simulations
    │   │   ├── EmailSendingSimulation.scala        # Email sending simulation
    │   ├── config/                                 # Gatling configurations
    │   │   └── gatling.conf                        # Gatling configuration file
    └── docker-compose.yml                          # Docker Compose configuration file

## Running the Project

To run this project, follow the steps below:

1. **Clone the repository**:
   Clone the repository to your local machine using the following command:

   ```bash
   git clone https://github.com/LucasHenriqueSZ/APIBenchmark-SingleThread-MultiThread-Reactive

2. **Navigate to the project directory:**
   Change into the cloned project directory:

    ````bash
    cd APIBenchmark-SingleThread-MultiThread-Reactive

3. **Run Docker Compose:**
   Use Docker Compose to start all the necessary services. This includes the Single-Threaded,
   Multi-Threaded, and Reactive APIs, as well as Gatling to perform the benchmark tests. Run the following command:

    ````bash
    docker-compose up --build

4. **Test Results:**
   The benchmark tests will be executed automatically as soon as the containers are up and running.
   The test results will be generated and stored in the `results` folder located within the `gatling` module. To view
   the results, simply navigate to the corresponding folder of the executed test and open the `index` page, where you
   can analyze the results in detail.

5. **Rerun the Tests:**
   To run the tests again, you can restart the Gatling container using the following command:

    ````bash
    docker-compose up gatling

## Notes

- **Docker Installation**: Ensure that Docker and Docker Compose are installed and configured correctly on your machine.
  It is essential that both are operational for the proper functioning of the project.


- **Accessing Test Results**: The test results can be found in the `gatling/results` folder. Within this folder, you can
  access the `index` page, which provides a detailed view of the benchmark test results. On this page, you can analyze
  the performance of the APIs, including metrics such as response time, error rate, and throughput.

## Licensing

This project is licensed under an Unlicense license. This license does not require you to take the license with you to
your project.