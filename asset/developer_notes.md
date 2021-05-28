# Developer Notes

## 1. Application

### 1.1. Where it is now

The application can do some of its most important features. It can generate event ID and it can read and validate other user’s code.

### 1.2. What’s till the first release

1.  Data model and persistent local storage need to get implemented
2.  Server API endpoints must have their pairs in the application
3.  Searching for and crating best practises with the cutting edge Android components to have a low-resource-cost app
4.  Layout design need to be optimized and refactored
5.  Dark mode and better cooperation with system colors have to be implemented
6.  JavaDoc have to be added to all components
7.  Depending on licensing of the code additional libraries have to be changed

### 1.3. Testing

1.  Need to make unit test strategy for every component
2.  Device tests are required from possible old devices to high end phones to provide wide accessibility
3.  Tests against QR code falsification
4.  User tests to improve design and functionality

## 2. Server

### 2.1. Where it is now

Server has an endpoint list and a basic check of required endpoint parameters.

### 2.2. What’s till the first release

1.  Endpoints need to get implemented
2.  SQL databases have to be made
3.  Validation and tokenization processes with 3rd party account providers (e.g. Google) have to be well implemented
4.  Event id and user id creation automatism have to be tested to avoid any hidden issue
5.  Change packaging from GET to POST or to mixed

### 2.3. Testing

1.  Test against application falsification
2.  Test against SQL injections
3.  Test against token falsification

## 3. Artificial Intelligence

### 3.1. Dataset

Much more data is needed to create a dataset that leads to a production ready AI system. We used some data sources during the hackathon but the validation of the potential results require new sources as well.

### 3.2. Targeted results

There are two main types of results to target. The first one is predictions about spread of diseases based on user’s connections and the second is predictions based on user orientation or interest. Though the two targets have similar aspects, there is an important difference between them. Data about users grouped by orientation or other interests more likely exists than real connection data. On the other hand our service provides quality data for us in the near future, therefore both targets worth the resources to get more developed.

### 3.3. Models

As in the field of the data, so in the field of the model a lot of very different approaches exist at the same time. The size and structure of a model is a performance question but it has strong relations with the type of the data and with dangers like overfitting as well. With the help of some experiments it is possible to find the ranges of models, which can be optimum solutions.

### 3.4. Training plan

One of the most important limits of the training is to avoid overfitting. Overfitting is quite a common failure in that kind of data, therefore strong regularization is required even if it slows down the training process significantly.

### 3.5. Optimization

In case of CoitoCare the highest optimization potential is in transfer learning. However users act similarly their activities have a lot of different attributes as well. A further optimization question is where to split users into groups based on aspects of artificial intelligence training and inferencing optimization.

### 3.6. Inference and use

The ideal model and inference environment is fast and lightweight to consume as little resources as possible. On the other hand saving resources is not the only one aspect of planning since accuracy, specificity or something else cab be more important. It depends on the case only.
