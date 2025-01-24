 Flipkart Shoes Automation Project

This repository contains an automated workflow developed in Katalon Studio to perform the following tasks on the Flipkart website:

 Features
1. Navigate to Flipkart:
   - Visit [Flipkart](https://www.flipkart.com/) homepage.
2. Handle Promotional Pop-ups:
   - Automatically handle any promotional pop-ups that may arise during navigation.
3. Search for "Shoes for Men":
   - Enter the query "Shoes for Men" into the search field and execute the search.
4. Extract Product Data from Pagination:
   - Gather the following details for products listed on pages 1 and 2:
     - MRP (Maximum Retail Price)
     - Discount Percentage
   - Save the extracted data into an Excel file for further analysis.
5. Quit Browser:
   - Close the browser after completing the tasks.

 Project Deliverables
- Excel File: Contains the extracted product data.
- PDF Report: A comprehensive report summarizing the automation workflow and results.
- Video Demonstration: Captures the entire workflow execution for clarity and review.

 Prerequisites
To execute the project, you need the following:
- Katalon Studio installed on your system.
- A web browser (preferably Google Chrome).
- Basic understanding of Groovy scripting and Katalon Studio.

 How to Use
1. Clone the Repository:
   ```bash
   git clone https://github.com/<your-username>/<repository-name>.git
   ```
2. Open the Project in Katalon Studio.
3. Run the Test Suite:
   - Execute the test suite to start the automation workflow.
4. Output Files:
   - The extracted product data will be saved as an Excel file in the `Reports` folder.
   - A PDF report and a workflow video are also included for review.

 Repository Structure
```
Flipkart-Shoes-Automation/
│
├── Test Cases/
│   ├── NavigateToFlipkart
│   ├── HandlePopUps
│   ├── SearchShoesForMen
│   ├── ExtractProductData
│   └── QuitBrowser
│
├── Data Files/
│   └── ProductData.xlsx
│
├── Reports/
│   ├── AutomationReport.pdf
│   ├── WorkflowVideo.mp4
│   └── Logs/
│
├── README.md
└── .gitignore
```

 Technologies Used
- Katalon Studio: For automation scripting and execution.
- Groovy: Scripting language used in Katalon Studio.
- Excel: For storing extracted product data.
- PDF: For automation report generation.
- Video Recording: Demonstrates the workflow.

