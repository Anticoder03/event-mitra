Based on the controller code you shared, here are all the REST APIs available in your **Event Ticket Booking Platform**.

---

# 👤 User APIs

**Base URL:** `/user`

| Method | Endpoint              | Description       |
| ------ | --------------------- | ----------------- |
| POST   | `/user`               | Create a new user |
| GET    | `/user`               | Get all users     |
| GET    | `/user/{id}`          | Get user by ID    |
| GET    | `/user/email/{email}` | Get user by email |
| PUT    | `/user/{id}`          | Update user       |
| DELETE | `/user/{id}`          | Delete user       |

---

# 🎉 Event APIs

**Base URL:** `/event`

| Method | Endpoint                           | Description                      |
| ------ | ---------------------------------- | -------------------------------- |
| POST   | `/event`                           | Create new event                 |
| GET    | `/event`                           | Get all events                   |
| GET    | `/event/{id}`                      | Get event by ID                  |
| GET    | `/event/location/{location}`       | Get events by location           |
| GET    | `/event/type/{type}`               | Get events by type               |
| GET    | `/event/price/lessthan/{price}`    | Events cheaper than given price  |
| GET    | `/event/price/greaterthan/{price}` | Events costlier than given price |
| GET    | `/event/after/{date}`              | Events after given date          |
| GET    | `/event/before/{date}`             | Events before given date         |
| PUT    | `/event/{id}`                      | Update event                     |
| DELETE | `/event/{id}`                      | Delete event                     |

> Date format:
>
> ```text
> yyyy-MM-dd
> ```
>
> Example:
>
> ```text
> /event/after/2026-08-01
> ```

---

# 🎫 Ticket APIs

**Base URL:** `/ticket`

| Method | Endpoint       | Description      |
| ------ | -------------- | ---------------- |
| POST   | `/ticket`      | Create ticket    |
| GET    | `/ticket`      | Get all tickets  |
| GET    | `/ticket/{id}` | Get ticket by ID |

---

# 📑 Booking APIs

**Base URL:** `/booking`

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| POST   | `/booking`      | Create booking    |
| GET    | `/booking`      | Get all bookings  |
| GET    | `/booking/{id}` | Get booking by ID |
| DELETE | `/booking/{id}` | Delete booking    |

---

# 📊 Complete API Summary

| Module  | POST | GET | PUT | DELETE |
| ------- | ---- | --- | --- | ------ |
| User    | ✅ 1  | ✅ 3 | ✅ 1 | ✅ 1    |
| Event   | ✅ 1  | ✅ 8 | ✅ 1 | ✅ 1    |
| Ticket  | ✅ 1  | ✅ 2 | ❌   | ❌      |
| Booking | ✅ 1  | ✅ 2 | ❌   | ✅ 1    |

## Total Endpoints

* 👤 User : **6**
* 🎉 Event : **11**
* 🎫 Ticket : **3**
* 📑 Booking : **4**

**Grand Total = 24 REST APIs**

---

## Suggested APIs to make the project more complete

For a production-ready Event Ticket Booking Platform, you could also add:

### Booking

* `PUT /booking/{id}` → Update booking
* `GET /booking/user/{userId}` → All bookings of a user
* `GET /booking/event/{eventId}` → All bookings for an event
* `GET /booking/ticket/{ticketId}` → Bookings by ticket
* `GET /booking/user/{userId}/event/{eventId}` → User's booking for an event

### Ticket

* `PUT /ticket/{id}` → Update ticket
* `DELETE /ticket/{id}` → Delete ticket
* `GET /ticket/event/{eventId}` → Tickets for an event
* `GET /ticket/type/{type}` → Filter by ticket type (VIP, General, etc.)
