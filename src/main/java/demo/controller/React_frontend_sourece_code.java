//package demo.controller;
//
//public class React_frontend_sourece_code {
//
//}
///*
//
//import React, { useState } from 'react';
//import './chat1.css'
//// Assuming your Spring Boot application runs on localhost:8080.
//// Adjust this URL if your backend is hosted elsewhere.
//const API_URL = 'http://localhost:8080/api/chat';
//
//function ChatbotFrontend() { 
//    // State to hold the user's input prompt
//    const [prompt, setPrompt] = useState('');
//    // State to hold the response from the backend
//    const [response, setResponse] = useState('Awaiting response...');
//    // State for loading status (when waiting for the API call)
//    const [isLoading, setIsLoading] = useState(false);
//
//    /**
//     * Handles the form submission: sends the prompt to the backend.
//     * @param {Event} e - The form submit event.
//     */
//    const handleSubmit = async (e) => {
//        // Prevent the default form submission (page reload)
//        e.preventDefault();
//
//        if (!prompt.trim()) {
//            setResponse('Please enter a prompt before submitting.');
//            return;
//        }
//
//        setIsLoading(true);
//        setResponse('Sending request to backend...');
//
//        try {
//            // 1. Prepare the data payload.
//            // This structure mimics your 'demo.dto.PromptRequest' class.
//            const data = {
//                prompt: prompt,
//                // Add any other fields your PromptRequest DTO might have, 
//                // e.g., 'userId', 'sessionId', etc.
//            };
//
//            // 2. Make the POST request to the Spring Boot endpoint.
//            const apiResponse = await fetch(API_URL, {
//                method: 'POST',
//                // Important: Set headers to let the server know we're sending JSON.
//                headers: {
//                    'Content-Type': 'application/json',
//                    // The @CrossOrigin("*") in your controller handles CORS, 
//                    // but these headers are good practice.
//                },
//                // Convert the JavaScript object to a JSON string.
//                body: JSON.stringify(data),
//            });
//
//            // 3. Check if the response was successful (HTTP status 200-299)
//            if (!apiResponse.ok) {
//                // If the response is not ok, throw an error with the status.
//                throw new Error(`HTTP error! Status: ${apiResponse.status}`);
//            }
//
//            // 4. Get the response body as plain text (since your controller 
//            // returns a `String`).
//            const chatResponse = await apiResponse.text();
//
//            // 5. Update the state with the successful response.
//            setResponse(chatResponse);
//
//        } catch (error) {
//            // Handle any errors during the fetch operation (e.g., network issues, 
//            // server error status).
//            console.error('Fetch error:', error);
//            setResponse(`Error: Failed to get response. Details: ${error.message}. 
//                Check your console and ensure the Spring server is running.`);
//        } finally {
//            // 6. Reset loading state regardless of success or failure.
//            setIsLoading(false);
//        }
//    };
//
//    return (
//        <div className='rr'>
//        <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
//            <h2>🤖 Chatbot Interface (React)</h2>
//            <p>Interacting with Spring Boot REST Controller on: <strong>{API_URL}</strong></p>
//
//            <form onSubmit={handleSubmit}>
//                <label htmlFor="promptInput" style={{ display: 'block', marginBottom: '8px', fontWeight: 'bold' }}>
//                    Enter your prompt:
//                </label>
//                <input
//                    id="promptInput"
//                    type="text"
//                    value={prompt}
//                    onChange={(e) => setPrompt(e.target.value)}
//                    placeholder="Type your message here..."
//                    disabled={isLoading}
//                    style={{ 
//                        width: '80%', 
//                        padding: '10px', 
//                        marginRight: '10px', 
//                        border: '1px solid #ccc' 
//                    }}
//                />
//                <button 
//                    type="submit" 
//                    disabled={isLoading}
//                    style={{ 
//                        padding: '10px 15px', 
//                        backgroundColor: '#007bff', 
//                        color: 'white', 
//                        border: 'none', 
//                        cursor: isLoading ? 'not-allowed' : 'pointer'
//                    }}
//                >
//                    {isLoading ? 'Sending...' : 'Submit Prompt'}
//                </button>
//            </form>
//
//            <hr style={{ margin: '20px 0' }} />
//
//            <div style={{ marginTop: '20px', border: '1px solid #eee', padding: '15px', backgroundColor: '#f9f9f9' }}>
//                <h3 style={{ marginTop: '0' }}>Server Response:</h3>
//                <p style={{ whiteSpace: 'pre-wrap', color: isLoading ? 'gray' : 'black' }}>
//                    {response}
//                </p>
//            </div>
//        </div>
//        </div>
//    );
//}
//
//// Don't forget to export the component so it can be used in your App.js
//export default ChatbotFrontend;
//
//*/
///* css 
///* MyComponent.css */
//.rr{
//     background-color: #cbecb1;
//     border: 5px solid #173302;
//     padding:50px;
//
//}
//.container {
//  max-width: 600px;
//  margin: 0 auto;
//  padding: 20px;
//  border: 1px solid #ccc;
//  text-align: center;
//}
//
//#main-title {
//  color: navy;
//  font-size: 2em;
//}
//
//.primary-button {
//  background-color: #007bff;
//  color: white;
//  padding: 10px 20px;
//  border: none;
//  border-radius: 5px;
//  cursor: pointer;
//}
//
//
//
//
//*/
///*
//
//// import React from "react";
//// import "bootstrap/dist/css/bootstrap.min.css";
//// import ReactDOM from "react-dom/client";
////  import App from './App';
//// import { BrowserRouter } from "react-router-dom";
//
//// const root = ReactDOM.createRoot(document.getElementById("root"));
//// root.render(
////   <BrowserRouter>
////     <App/>
////   </BrowserRouter>
//// );
//
//import React from 'react';
//import ReactDOM from 'react-dom/client';
//import App from './App';
//import ChatbotFrontend from './chat/Chat';
//import Appp from './list_files/App';
//import SingleDivEcommercePage from './prg_1/pc1';
//
//const root = ReactDOM.createRoot(document.getElementById('root'));
//root.render(
//  <React.StrictMode>
//    
//    <ChatbotFrontend />
//   
//   
//   
//  </React.StrictMode>
//);
//
//// If you want to start measuring performance in your app, pass a function
//// to log results (for example: reportWebVitals(console.log))
//// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//
////index.js
//*/