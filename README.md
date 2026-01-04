# Recipe/Nutrition Chat Bot

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

The backend is a Java Spring Boot project.

## Next steps
1. Frontend
    a. No immediate steps
2. Backend
    a. Understand why project shuts down immediately upon build - fix that so that Controller can be hit by the front end
3. RAG
    a. Create pipeline to ingest data from Spoonacular/USDA/Other Food APIs, chunk ingested data, embed data, and store in local FAISS vector database
    b. Create MCP service to grant AI Chat Bot controller access to context contained in RAG for queries
    c. Stretch goal - Create pipeline to use beautiful soup to scrape and process HTML data from Justine Snacks recipes
4. Integration
    a. Run both front end and back end to see if the controller will connect to the LLM and return answers from the chatbot

## Important Links:
- Google AI Studio: https://aistudio.google.com/app/
- Claude Cookbook References: https://github.com/anthropics/claude-cookbooks?tab=readme-ov-file

## To Run Backend Locally:
From backend project root directory run:
mvn spring-boot:run

## To Run Frontend Locally
From frontend project root directory run:
npm start