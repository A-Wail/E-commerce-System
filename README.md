# 🛒 Simple E-Commerce Console App (Internship Task)

A simple Java console-based e-commerce application demonstrating Object-Oriented Programming (OOP) principles. Users can browse products, add them to a cart, and simulate purchases.
---

## ✅ Features

- Define products with:
    - Name, price, quantity
    - Optional expiry date
    - Optional weight for shipping
-Product Catalog: List of items with prices and categories.
- Calculate shipping cost based on product weight
- Print a full checkout invoice with itemized details

---

## 📦 Product Types

- `Product`: Non-expirable, non-shippable
- `ExpirableProduct`: Has expiry date
- `ShippableProduct`: Has shipping weight
- `ExpirableShippableProduct`: Has both expiry and weight

---

## 🧠 Business Rules

The system validates the following:

- Product name must not be empty
- Price must be positive
- Quantity must be positive 
- Expirable products must have a future expiry date
- Shippable products must have weight > 0
- Cart items cannot exceed available product quantity

---

## 🛠 Technologies

- Java 22
- Object-Oriented Design
- Rule-based validation
---

## 📁 Structure Overview

```bash
src/
└─ business/
  ├─ entity/
  ├─ interfaces/
  ├─ products/
  ├─ shopping/
    └─ Main.java
```


## 📌 Considerable notes
- All rules are pluggable and reusable.
- Easily extendable for taxes, discounts, and more.

