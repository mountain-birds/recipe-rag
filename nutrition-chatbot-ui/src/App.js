// src/App.js
import React, { useState } from "react";

function App() {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState("");

  const sendMessage = async () => {
    if (!input.trim()) return;

    const response = await fetch("http://localhost:8080/chat", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ message: input }),
    });
    const data = await response.json();

    setMessages([
      ...messages,
      { role: "user", text: input },
      { role: "bot", text: data.reply },
    ]);
    setInput("");
  };

  return (
    <div
      style={{
        width: "auto",
        margin: "auto",
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#121212",
        color: "#f1f1f1",
        minHeight: "100vh",
        padding: "20px",
      }}
    >
      <h2 style={{ textAlign: "center", color: "#00ff99" }}>
        🥗 Recipe & Nutrition Chatbot
      </h2>

      {/* Chat window */}
      <div
        style={{
          width: "400px",
          margin: "auto",
          border: "1px solid #333",
          borderRadius: "8px",
          padding: "10px",
          height: "300px",
          overflowY: "scroll",
          backgroundColor: "#1e1e1e",
        }}
      >
        {messages.map((m, i) => (
          <p key={i} style={{ margin: "5px 0" }}>
            <b style={{ color: m.role === "user" ? "#4da6ff" : "#00ff99" }}>
              {m.role}:
            </b>{" "}
            {m.text}
          </p>
        ))}
      </div>

      {/* Input bar */}
      <div style={{ display: "flex", marginTop: "10px", width: "400px", margin: "10px auto 0 auto" }}>
        <input
          type="text"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          placeholder="Type your question..."
          style={{
            flex: 1,
            padding: "10px",
            borderRadius: "4px",
            border: "1px solid #333",
            backgroundColor: "#2a2a2a",
            color: "#f1f1f1",
          }}
          onKeyDown={(e) => e.key === "Enter" && sendMessage()}
        />
        <button
          onClick={sendMessage}
          style={{
            marginLeft: "8px",
            padding: "10px 15px",
            backgroundColor: "#4da6ff",
            color: "white",
            border: "none",
            borderRadius: "4px",
            cursor: "pointer",
          }}
        >
          Send
        </button>
      </div>
    </div>
  );
}

export default App;