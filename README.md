# Product_Catalog
It will be Product service for E-commerce project


Example of product response in json format:

{
  "id": 101,
  "created": "2024-07-01T10:00:00Z",
  "lastModifiedAt": "2024-07-10T08:30:00Z",
  "title": "iPhone 15 Pro",
  "description": "Flagship Apple phone with improved battery and camera.",
  "price": 129999.00,
  "stockQuantity": 10,
  "specs": "A17 Pro chip, 120Hz OLED, 512GB Storage",

  "category": {
    "id": 1,
    "categoryName": "Smartphones",
    "created": "2024-06-15T12:00:00Z",
    "lastModifiedAt": "2024-06-20T15:00:00Z"
  },

  "attributeList": [
    { "keyName": "Processor", "value": "A17 Pro" },
    { "keyName": "Storage", "value": "512GB" },
    { "keyName": "Camera", "value": "48MP Triple" },
    { "keyName": "Display", "value": "6.1-inch OLED" }
  ],

  "productImages": [
    { "imageUrl": "https://cdn.example.com/images/iphone15-front.jpg" },
    { "imageUrl": "https://cdn.example.com/images/iphone15-back.jpg" }
  ],

  "reviews": [
    {
      "email": "user1@example.com",
      "comment": "Amazing performance and battery life!",
      "ratings": 5
    },
    {
      "email": "user2@example.com",
      "comment": "Great camera but expensive.",
      "ratings": 4
    }
  ]
}

