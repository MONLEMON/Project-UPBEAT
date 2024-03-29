import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Page2 from "./Page2";
import Page3 from "./Page3";
import Page4 from "./Page4";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "page2",
    element: <Page2 />,
  },
  {
    path: "page3",
    element: <Page3 />,
  },
  {
    path: "page4",
    element: <Page4 />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
