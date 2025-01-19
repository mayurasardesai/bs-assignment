
## Getting Started

This is BrowserStack Round 2 Assignment.

### Prerequisites

Please install Java and Gradle before build this project.

### Setup

You need to set up three environment variables for smooth execution of the test cases as below : 
 ```sh
    export RAPIDAPI_KEY=<RAPID API KEY VALUE>
    export USER_NAME=<BROWSERSTACK USER NAME VALUE>
    export ACCESS_KEY=<BROWSERSTACK ACCESS KEY VALUE>   
```
Please declare above environment variabled in bash profile or .zshrc file.

### Execution

To build the project, run below command : 
 ```sh
    gradle build -x test
```
To execute the test locally : 
 ```sh
    gradle test
```
