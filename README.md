# 🚗 Dealers Auto Center — Backend + Frontend + Postman

Full-stack implementation for:
- **Task 1:** Dealer & Vehicle Management APIs
- **Task 2:** Payment Gateway Simulation (status auto-updates to SUCCESS after 5s)
- **Frontend:** Single Page UI (HTML/CSS/JS)
- **Testing:** Postman collection (no Swagger)

---

## 🧱 Tech Stack
- **Backend:** Java 17, Spring Boot 3, Spring Web, Spring Data JPA, Validation
- **Database:** MySQL 8+
- **Frontend:** HTML, CSS, JavaScript (Fetch API)
- **Docs/Testing:** Postman collection

---

## ⚙️ Setup

### 1) MySQL
Create DB and update credentials in `backend/src/main/resources/application.properties`:
```sql
CREATE DATABASE dealerdb;
spring.datasource.url=jdbc:mysql://localhost:3306/dealerdb
spring.datasource.username=your_user
spring.datasource.password=your_pass

1---> API Endpoints
Dealers
POST /api/dealers — create
GET /api/dealers — list all
GET /api/dealers/{id} — get by id
PUT /api/dealers/{id} — update
DELETE /api/dealers/{id} — delete

 Dealer Json
{
  "name": "John Dealer",
  "email": "john@example.com",
  "subscriptionType": "PREMIUM"
}

2--->Vehicles
POST /api/vehicles — create
GET /api/vehicles — list all
GET /api/vehicles/{id} — get by id
PUT /api/vehicles/{id} — update
DELETE /api/vehicles/{id} — delete
GET /api/vehicles/premium — vehicles for PREMIUM dealers

Vehicle JSON
{
  "dealerId": 1,
  "model": "BMW X5",
  "price": 50000,
  "status": "AVAILABLE"
}

3--->Payment (Simulation)

POST /api/payment/initiate — initiate; status = PENDING, auto → SUCCESS after ~5s

GET /api/payment/{id} — fetch payment status

Payment JSON

{
  "dealerId": 1,
  "amount": 999.0,
  "method": "UPI"
}
 Response

{
  "id": 3,
  "dealerId": 1,
  "amount": 999.0,
  "method": "UPI",
  "status": "PENDING",
  "createdAt": "2025-08-20T12:34:56.789"
}

Frontend Usage

frontend/index.html

Tabs:
Dealers: add + list
Vehicles: add + list
Premium Vehicles: click Refresh to view
Payment: initiate (will show PENDING then SUCCESS after ~6s auto-check)



