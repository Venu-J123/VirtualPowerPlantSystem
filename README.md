<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
</head>

<body>

  <h1>Virtual Power Plant System</h1>

  <h2>Overview</h2>

  <p>The Virtual Power Plant System is a cloud-based energy provider that aggregates distributed power sources. It allows users to manage batteries, store information, and retrieve battery details within a specified postcode range.</p>

  <h2>Features</h2>

  <ul>
    <li><strong>Save Batteries:</strong> Endpoint to save a list of batteries, including name, postcode, and watt capacity.</li>
    <li>
      <strong>Get Batteries in Postcode Range:</strong>
      <ul>
        <li>Endpoint to retrieve a list of batteries within a specified postcode range.</li>
        <li>Provides statistics such as total and average watt capacity.</li>
      </ul>
    </li>
  </ul>

  <h2>Technologies Used</h2>

  <ul>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>Lombok</li>
    <li>MySQL (or your preferred database)</li>
  </ul>

  <h2>Setup Instructions</h2>

  <ol>
    <li>Clone the repository: <code>git clone https://github.com/your-username/VirtualPowerPlantSystem.git</code></li>
    <li>Navigate to the project directory: <code>cd VirtualPowerPlantSystem</code></li>
    <li>Configure your database connection in <code>application.properties</code>.</li>
    <li>Build and run the project: <code>./mvnw spring-boot:run</code> (or use your preferred method).</li>
  </ol>

  <h2>API Endpoints</h2>

  <div class="endpoint">
    <h3>Save Batteries</h3>
    <pre>
      <code>POST /api/batteries/save</code>
    </pre>
    <h4>Request</h4>
    <pre>
      <code>[
  {
    "name": "Battery1",
    "postcode": "12345",
    "wattCapacity": 1000
  },
  {
    "name": "Battery2",
    "postcode": "67890",
    "wattCapacity": 1500
  }
]</code>
    </pre>
    <h4>Response</h4>
    <pre>
      <code>{
  "message": "Batteries saved successfully"
}</code>
    </pre>
  </div>

  <div class="endpoint">
    <h3>Get Batteries in Postcode Range</h3>
    <pre>
      <code>GET /api/batteries/getByPostcodeRange?startRange=10000&endRange=20000</code>
    </pre>
    <h4>Response</h4>
    <pre>
      <code>{
  "batteryNames": ["Battery1", "Battery2"],
  "totalWattCapacity":"2000" 
  "AvarageWattCapacity":"1000"
