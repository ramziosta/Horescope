# Horoscope Web App
A user-friendly web app that utilizes APIs, fetch, and queries to retrieve user-specific horoscope information and manipulate the DOM.

## Technologies Used
- Java
- Javalin
- Maven
- HTML
- CSS
- Postgres
- SQL
- Fetch API
- JavaScript DOM Manipulation

## Features
- Register a new account
- Login with personal information
- Retrieve daily horoscope
- Personalized information display

## How it Works
1. The user signs up for a new account by entering their personal information.
2. Upon successful login, the user enters the app and can retrieve their daily horoscope and personalized information.
3. The app utilizes fetch and hits the API to retrieve information.
4. The data retrieved is displayed by manipulating the DOM using JavaScript DOM manipulation techniques.

### Downloading and Running the App
To download and run the Employee App, follow these steps:

Clone the repository to your local machine using Git or download the ZIP file
Ensure that you have the following software installed:
Java
Maven
Docker
Postgres
Redis
Navigate to the project directory in your terminal or command prompt
Run the following command to build the Docker image:
Copy code
docker-compose build
Start the Docker containers with the following command:
Copy code
docker-compose up
The app should now be running at http://localhost:8080.
Note: You may need to configure the database and Redis connections to match your local setup. Please consult the documentation for Postgres and Redis for more information.


If you have any questions or feedback, feel free to reach out to me.

MIT License

Copyright (c) 2023 Ramzi Osta 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
