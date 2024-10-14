# MCQ Application

## Introduction
The **MCQ Application** is an Android-based mobile app that allows users to answer multiple-choice questions on various topics. The app dynamically retrieves quiz content from a Firebase database, making it easy to update questions and answers without modifying the app itself. This application is designed to offer a simple, intuitive user interface built with XML and powered by Kotlin. The real-time database functionality ensures that users always have access to the latest quiz content.

## Features
- **Firebase Integration**: All questions and answers are stored in Firebase, allowing for real-time updates and management of quiz data.
- **Multiple Quiz Topics**: The app supports a variety of quiz topics, with the ability to dynamically load new topics from the database.
- **User-Friendly Interface**: Designed with XML layouts, the app offers a smooth user experience.
- **Real-time Data Synchronization**: Firebase ensures that users get the latest set of questions and answers without needing to update the app.
- **Score Tracking**: Users can see their scores immediately after completing the quiz.

## Tech Stack
- **Kotlin**: Used as the primary programming language for Android app development.
- **XML**: Utilized for designing the user interface components.
- **Firebase**: Used for storing and retrieving quiz data and ensuring real-time synchronization.
    - Firebase Realtime Database for storing questions, options, and answers.
    - Firebase Authentication for user management (if applicable).
    - Firebase Cloud Storage for hosting images or other assets.

## Screenshots
Below is a sample screenshot of the MCQ app in action:

![MCQ App Screenshot](path-to-image.png)

<!-- You can manage image size like this -->
<img src="path-to-image.png" alt="MCQ App Screenshot" width="300">
