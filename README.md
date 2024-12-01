# Forum API Documentation

This project is a Spring Boot application that provides a forum platform for user registration, question creation, and answers to questions. The APIs handle user actions such as creating, viewing, and deleting forum content.

## API Endpoints

### POST Endpoints

1. **User Login**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/usercreate`
   - **Description:** Creates a new user account.
   - **Request Format:** JSON
     ```json
     {
         "username": "aaaa",
         "email": "aaa123@gmail.com",
         "password": "aaaaa@123"
     }
     ```

2. **Create a Question**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/questions`
   - **Description:** Allows a user to create a new question under a specific topic.
   - **Request Format:** JSON
     ```json
     {
         "questions": "What is java",
         "topic": "java",
         "userid": 2
     }
     ```

3. **Create an Answer**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/createanswers`
   - **Description:** Allows a user to post an answer to a specific question.
   - **Request Format:** JSON
     ```json
     {
         "answer": "It is a statically typed language",
         "question": "What is java",
         "userid": 2
     }
     ```

### GET Endpoints

1. **View All Topics**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/alltopics`
   - **Description:** Retrieves a list of all topics.

2. **View All Questions by Topic Name**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/allquestionsbytopic/java`
   - **Description:** Retrieves all questions under the specified topic (`java` is a placeholder for the topic name).

3. **View All Questions**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/findallquestions`
   - **Description:** Retrieves a list of all questions.

4. **View All Answers by Question**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/question/What is java`
   - **Description:** Retrieves all answers to a specific question (`What is java` is a placeholder for the question).

5. **View User Details by Username**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/usersdetails/username/aaaa`
   - **Description:** Retrieves user details by username (`aaaa` is a placeholder for the username).

6. **View All Users**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/allusers`
   - **Description:** Retrieves a list of all users.

### DELETE Endpoints

1. **Delete an Answer**
   - **Endpoint:** `https://forum-deployment-latest.onrender.com/answers/1`
   - **Description:** Deletes a specific answer by its ID (`1` is a placeholder for the answer ID).

## Notes

- Replace placeholders in the endpoints (e.g., `java`, `What is java`, `1`, `aaaa`) with the appropriate values.
- All API requests should use JSON format for payloads where applicable.
- Ensure the application is deployed at `https://forum-deployment-latest.onrender.com` before making API calls.

For further details or troubleshooting, refer to the project documentation or contact the development team.
