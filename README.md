# Recipe/Nutrition Chat Bot

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

The backend is a Java Spring Boot project.

## Next steps
1. Frontend
    a. No immediate steps
2. Backend
    a. Create Spring Boot Project using Spring Initializer (understand if project is currently spring boot)
    b. Create Google Gemini key and save it in an application.yml file to be used by the controller at runtime
3. RAG
    a. Create pipeline to ingest data from Spoonacular/USDA/Other Food APIs, chunk ingested data, embed data, and store in local FAISS vector database
    b. Create MCP service to grant AI Chat Bot controller access to context contained in RAG for queries
    c. Stretch goal - Create pipeline to use beautiful soup to scrape and process HTML data from Justine Snacks recipes

## Important Links:
- Google AI Studio: https://aistudio.google.com/app/
- Claude Cookbook References: https://github.com/anthropics/claude-cookbooks?tab=readme-ov-file