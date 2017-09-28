# rsimulator-http docker #

This docker image run an instance of the [rsimulator-http](https://github.com/bjuvensjo/rsimulator).

## Usage ##

### Run ###

    docker run -d -t -i -p 8081:8080 --rm --name rsimulator-http -v $(PWD)/rsimulator_home:/var/rsimulator_home bjuvensjo/rsimulator-http

### Data ###

The rsimulator testdata should be placed in the directory rsimulator_home

### Log ###

The rsimulator write logs to rsimulator_home/rsimulator.log
