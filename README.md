# Nettverk Humidity

### **Abstract**

When building a system for monitoring plant humidity, there are multiple factors that need to be taken into consideration. Osmosis, diffusion and active transport are the three processes taking place when a plant absorbs water and other minerals of the soil and can be quite complex. The system we are applying for this project monitors only the soil humidity of a plant, and therefore we need to be able to manually calibrate the frequency of watering the plant due to the different environments the plants can be placed in. This project provides a solution to the monitoring of the soil humidity in a safe and reliable way, and visualizing it through a basic front-end web app. Some features, like checking when the plants were last watered, were scrapped because of lack of time. In future developments to this project would be implementing monitoring of soil quality and amount of sunlight.

### **Introduction**

The plant-monitoring system is a solution meant primarily for private homes. Almost every home in the western world has at least one plant, but not necessarily a person with green thumbs that can take care of the plant. With this system all that is needed is access to a phone or a computer and the rest is taken care of. With the help of moisture sensors, a database full of plants, this system will help house plants all over the world. 

We describe all the techniques and information behind how the final product would function and calculate everything it needs to keep the plants healthy. A small insight into the work process and which other subjects are related to the project is presented later in the report. Finally a look at the results we made, and which lessons we learned throughout the project.

### **Theory and technology**

#### **Time, humidity and database**

There are in total three factors that decide when a plant needs water in this system; time, humidity and the information provided by the database on the specific plant. 
Tracking of time is a necessity as the process of watering a plant is time-based. Watering a plant is in almost all cases a repeating cycle and knowing the previous states of humidity of a plant is crucial for deterring when it needs refill. Humidity and time are combined to deter whenever a plant needs to be watered, which we will come back to later in this paper. In theory, the humidity of the plant could alone provide enough information about when to water the plant next, but for a more accurate result the time should also be taken into consideration. The previous watering of a plant, as well as its current humidity, is stored in a field of the specific plant, and not in the generic table of the plant species providing information about its suggested watering cycles. Having a unique item for each active plant in the database is unavoidable, as each plant needs to be monitored individually, and two plants of the same species can be on two different watering cycles.

#### **Calculating when a plant needs to be watered**

Recognizing when a plant needs water is one of the main functionalities of the system. As mentioned earlier, this is done with the information from the database about each plant individually. The individual data provides information about the plants last watering and its current humidity. The generic plant species data provides information about how often the plant should be watered, as well as how wet the soil should be. This is all the data we need to be able to calculate when a plant needs water.
As plants usually thrive in a range of humidity rather than a specific number, we can use this information to make sure the plant soil stays in the ideal range. A plant with a suggested range of 40% - 60% humidity will need to be watered some time before it reaches 40%. On the other hand, you don’t want to water it when it is close to 60%, as it can lower the suggested humidity level and in the worst case drown the plant. To avoid these situations, and simple mathematical formula can be applied:

*$$ H \leq 0.3(H_2 - H_1) + H_1 $$*

where H is the measured humidity of the plant, H2 is the upper recommended humidity range and H1 is the lower recommended humidity range. This formula ensures that the system will notify the user to water the plant when it reaches 30% of the suggested humidity range, giving the user time to water the plant before it drops below the range, as well as making sure it’s not drowning the plant. This formula may not be ideal for every single plant but is a generic formula for knowing when a plant needs water.
As mentioned earlier in this paper, information about the last watering is also taken into consideration when dealing with this system. Therefore, the formula needs to be extended to include this data. As the humidity level of the plant is the most crucial aspect, the time of the last watering should only slightly change the suggested watering of the plant. The complete formula would look like this:

*$$ H \leq 0.3(H_2 - H_1) + H_1 + 2(T_2 - T_1) $$*

where T2 is the suggested number of days between each watering and T1 is the current number of days since the last watering took place. If it has gone less days than recommended, for example the recommended days to wait is 5, but it has gone 3 days, the sum of these two numbers will be positive and added to the total humidity. On the other hand, if you have exceeded the recommended days to wait, the sum will be negative and subtracted from the total humidity. This means that every day offset of the recommended number of days between watering will affect the total humidity value by two percent. By doing this, we will accomplish a more accurate result for when a plant should be watered. 
This formula should be checked for each individual plant by the system several times a day, to ensure more reliable data on the active plants. In short, any humidity sensor sensing a humidity lower than the value given by this formula, will notify the water of the correlated plant. 

#### **Recognizing when a plant is given water**

Recognizing when a plant is given water is relatively simple. It is done by detecting an increase in the soil humidity of any given plant. The challenge is to filter out the natural increase of soil humidity due to natural rise in air humidity, which will also affect the soil. The differences between these scenarios lies in the rate of humidity increase as well as the total amount it increases. Any increase in soil humidity due to changes in the air, will be significantly less dramatic than the ones caused by watering. Taking this into consideration, we can make a mathematical formula which detects watering of plants, and filters out changes due to other factors:

*$$ \bigtriangleup H \geq {H_2 - H_1 \over 2} $$*

where delta H is the change in soil humidity over a certain time detected by the sensor, H2 is the top range humidity percentage suggested for the plant and H1 is the bottom range humidity percentage suggested for the plant. We then divide the difference between these two variables by 2, making it 50% of the whole range. This means that whenever a humidity change in the soil is bigger than 50% of the suggested range, it counts as a watering. 
The reason for making it exactly 50% of the whole range has to do with the formula for detecting when the plant needs water. Since you will be notified when the soil is dropping below 30% of the recommended humidity, the user is supposed to water the plant as soon as possible. Watering it at exactly 30% will not happen every time, but when it happens, watering it up 50% more will make sure the user does not exceed the upper range limit of humidity for the plant. In the case of a user filling up when the soil is at 30% of the humidity range, the new soil humidity level will be at 80% of the recommended humidity range. This allows for excessive water to be added with a margin of 20% without exceeding the recommended amount.
For any plant located in an outside environment, rain is a possibility, although not necessarily a complication. This allows for detection of watering plants naturally and prevents the user from watering the plant excessively. This way, plants in an outside environment naturally need less water from the user, as rain helps keep the humidity up. The system does not differentiate between the two sources of watering, as it is not necessary. 

#### **Storing data for individual plants**

Data is stored for every single plant active in the system individually. Each plant owns four different fields: the **ID** of the plant, the **species**,  the **soil humidity** as well as the **time of the last watering**. Plants can be added, removed or modified at any time.
- The plant ID is unique to that plant, and helps the system as well as the user to differ between the different plants in the system
- The specie of the plant is used by the system to match data of when the plant should be watered as well as how humid the soil should be
- The soil humidity contains information about how humid the soil was the last time a sensor check was done. This information is then used to calculate if the plant needs water
- The time of the last watering contains information about when the plant was last given water. This information is also used to calculate the next watering of the plant 

![image](https://user-images.githubusercontent.com/74419768/206041503-0281261e-3128-4d39-9a5c-d14bffbbdd2b.png)


#### **Common plants in households and workplaces**

The system provides data on some of the most common household and workplace plants, which is stored in a database. Each plant species holds a **species** name, suggested **soil humidity** level and a recommended **watering cycle**. This makes it easier for the user to quickly add a new plant to the collection, without having to find the information on their own. The user can add their own species to this database if wished. 
- The **specie** name makes it possible for the user to find the information of a specific species, while the system uses the specie name to match the active plants in the system
- The suggested **soil humidity** contains a recommended range of soil humidity in percentage. This value is broken down to two different fields: upper range limit and lower range limit.
- The **watering cycle** field contains information about how often the plant should be watered. This is stored as a whole number, representing days. This number tells how many days apart each watering should be.

Below is a list of some common plants that the system owns information about.

Chart of recommended soil humidity for the most common household plants from https://www.acurite.com/blog/soil-moisture-guide-for-plants-and-vegetables.html

![image](https://user-images.githubusercontent.com/74419768/206042185-2c4cd0db-fdb6-4ad3-ae5a-8bcd50666964.png)


#### **Intro to technical theory**

We are using HTTP for react. TLS for data transmission from rpi, IP so rpi knows where to send the data. Ethernet to connect the server and rpi to the same lan. The rpi sends a object with humidity info, plant id and measure time.

Since we are using Spring Boot, we have made controllers with the GET mapping request to get all the plants with the different humidities from the mariadb. We have one endpoint for each sensor that gives us the newest humidity data for each plant. /humidity/1 - 3

The TLS client has a function for generating random data, it was used to fill the database with dummy data at the start. 

The data can be visualized using chart.js.

#### **Protocols used for the solution**

We have used TLS for transferring data from the raspberry pi nodes into the main backend server.
The backend runs a multithreaded application. A spring backend on port 8080 and a TLS socket on port 5555, that receives the encrypted data and puts it into the database. We also use HTTP on our frontend that runs on port 3000.

#### **TLS advantages over MQTT**

We chose TLS over MQTT because TLS provides encryption of data in transit, whereas MQTT does not. This ensures that sensitive information is protected from being intercepted and read by other people.

TLS uses digital certificates to authenticate the identity of the communicating parties, whereas MQTT does not have any built-in mechanism for authentication. This ensures that only authorized parties can access the communication channel.

TLS uses stronger encryption algorithms, such as AES and RSA, which provide higher levels of security than the encryption algorithms used in MQTT.

TLS is a widely supported and standardized protocol, whereas MQTT is a proprietary protocol with limited support and interoperability. This makes it easier to integrate TLS into existing systems and infrastructure.


#### **Infrastructure**

![c09ab19c628142586885a7300dc182a8](https://user-images.githubusercontent.com/74419768/206033401-2f1db8f2-e663-4318-849d-36e15ceae43d.png)

#### **IAC**

The frontend, backend and database deployment is fully automated and they are deployed as docker containers on NTNU’s Openstack server using Ansible and openstack Heat.

The ansible and openstack code is available here: 
https://github.com/tama3ti/IAC_IDATA2502

#### **Openstack**

We have a simple openstack heat template that creates a ubuntu vm with a static floating IP and my public ssh key.[1]

#### **Ansible**

Our ansible playbook installs maven, npm and docker on the above ubuntu server, it then pulls our repo and configures it, when everything is ready and tested, it runs docker compose.

![image](https://user-images.githubusercontent.com/74419768/206040498-c71ae95d-3708-436d-87cb-5cf2df2e3b21.png)

No password is stored in github instead we use ansible to insert the passwords. In the picture above you can see ansible search for var dbpasswd in a file and replace it with the user inputted password.[1]

#### **CI/CD**

![image](https://user-images.githubusercontent.com/74419768/206040436-50ad4a3c-0a68-4ff7-8b02-d7b66de474a4.png)

As you can see github actions tests our frontend and backend code and runs docker-compose if it is successful to deploy the app. We are using a self-hosted runner which tests our application and deploys it. As you can see above we have 7 jobs that are run and depend on each other. They are run every time someone pushes to main or creates a pull request. [1]

### **Connection to other subjects**

Database modeling and databases. (Mariadb)
Web Technology (React Frontend)
Application Development (Spring Boot backend)
Skytjenester (IAC and CI/CD)
Operativsystemer med systemprogrammering (Multithreading)
Programming 1 and 2

### **Methodology**

We have worked in conjunction with other subjects. Using a CI/CD assignment and implementing it in this humidity’s project repository.
User tests have been performed during the entire process. We made templates on figma of the frontend and checked if it was readable for the users. When the frontend has been developed we also took in feedback from the users. Mostly focused on design. The users understood the current humidity and what plant it belongs to.

### **Results**

The frontend is hosted here:
http://10.212.25.196:3000/

We did not have time to deploy our client code on raspberry pi’s. Instead we run the client code on a docker container that randomly generates humidity data for the plants.

We use TLS for sending data between the raspberryPI(container) to our springboot backend. Then display the humidity with react that takes out the data from the database.

### **Conclusion and future work**

Our deployed solution works very well (for the features we have), all data sent is encrypted and nicely displayed on the website. It also has potential for future developments. Monitoring of the nutrients in the plant's soil, or monitoring of the amount of sunlight hitting the plant are examples of future features. The making of an easy to use mobile application would also be a high priority as this would make the service accessible to an increased amount of users. After the implementation of more features and better accessibility, the implementation of a subscription based system could be implemented to monetize the application.

### **Refrences**

1. Cloud services administration Assignment - Mateusz Picheta
2. https://iot.stackexchange.com/questions/1509/performance-of-mqtt-over-tls-vs-mqtt
