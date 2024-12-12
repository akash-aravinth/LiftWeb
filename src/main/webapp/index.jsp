<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page Layout</title>
    <style>
        /* Basic reset */
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
            height: 100%;
        }
        .sidebar {
            width: 30%;
            background-color: #f4f4f4;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .main-content {
            width: 70%;
            padding: 20px;
            display: flex;
            flex-wrap: wrap;
            margin : auto;
            gap : 60px;
        }
        form{
        background-color: white;
                    padding: 20px;
                    border-radius: 8px;
                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                    width: 300px;
        }
        label {
                    font-weight: bold;
                    display: block;
                    margin-bottom: 8px;
                }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <form action="/LiftWeb/api/requests" method="post">
                    <label for="source">Name:</label>
                    <input type="number" id="source" name="source" required>
                    <label for="destination">Email:</label>
                    <input type="number" id="destination" name="destination" required>
                    <label for="passengers">Message:</label>
                    <input id="passengers" name="noOfPassengers" required></input></br>
                    <input type="submit" value="Submit">
                </form>
        </div>

        <div class="main-content">
            <!-- Table 1 -->
            <table>
                <thead>
                    <tr>
                        <th>Column 1</th>
                        <th>Column 2</th>
                    </tr>
                </thead>
                <tbody id="tableBody">

                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
