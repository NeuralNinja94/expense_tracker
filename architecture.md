# Expense Tracker - Multi-User Architektur

## System-Übersicht

```mermaid
graph TB
    subgraph Frontend
        React[React Application]
        Login[Login/Signup Pages]
        Dashboard[Dashboard]
    end
    
    subgraph Backend
        API[Spring Boot REST API]
        Security[Spring Security + JWT]
        Controllers[Controllers]
        Services[Services]
        Repositories[Repositories]
    end
    
    subgraph Database
        MySQL[(MySQL Database)]
    end
    
    React --> API
    Login --> Security
    Dashboard --> Controllers
    Controllers --> Services
    Services --> Repositories
    Repositories --> MySQL
```

## Multi-User Authentication Flow

```mermaid
sequenceDiagram
    participant User
    participant Frontend
    participant Backend
    participant Database
    
    User->>Frontend: Signup/Login
    Frontend->>Backend: POST /api/auth/login
    Backend->>Database: Validate Credentials
    Database-->>Backend: User Data
    Backend->>Backend: Generate JWT Token
    Backend-->>Frontend: Token + User Info
    Frontend->>Frontend: Store Token in localStorage
    
    Note over Frontend,Backend: Subsequent Requests
    Frontend->>Backend: GET /api/expenses (with Token)
    Backend->>Backend: Validate Token
    Backend->>Database: Fetch User's Expenses
    Database-->>Backend: Expenses
    Backend-->>Frontend: User's Expenses Only
```

## Datenbank-Schema (Multi-User)

```mermaid
erDiagram
    USER ||--o{ EXPENSE : owns
    USER ||--o{ EXPENSE_SHEET : owns
    
    USER {
        Long id PK
        String benutzername
        String passwort
        LocalDate erstellungsdatum
    }
    
    EXPENSE {
        Long id PK
        String titel
        Double betrag
        String kategorie
        LocalDate datum
        Long user_id FK
    }
    
    EXPENSE_SHEET {
        Long id PK
        Double budget
        String monat
        Long user_id FK
    }
```

## Backend-Architektur (DTO Pattern)

```mermaid
graph LR
    Client[Client Request] --> Controller[Controller]
    Controller --> DTO[DTO]
    DTO --> Mapper[MapStruct Mapper]
    Mapper --> Entity[Entity]
    Entity --> Service[Service]
    Service --> Repository[Repository]
    Repository --> DB[(Database)]
    
    DB --> Repository
    Repository --> Service
    Service --> Entity
    Entity --> Mapper
    Mapper --> DTO
    DTO --> Controller
    Controller --> Response[Client Response]
```

## API Endpoints

```mermaid
graph TD
    API[Spring Boot API]
    
    API --> Auth[/api/auth]
    Auth --> Login[POST /login]
    Auth --> Signup[POST /signup]
    
    API --> Users[/api/users]
    Users --> GetUsers[GET /]
    Users --> CreateUser[POST /]
    
    API --> Expenses[/api/users/:userId/expenses]
    Expenses --> GetExpenses[GET /]
    Expenses --> CreateExpense[POST /]
    Expenses --> UpdateExpense[PUT /:id]
    
    API --> Sheets[/api/expense-sheets]
    Sheets --> GetSheets[GET /]
    Sheets --> CreateSheet[POST /]
    
    style Auth fill:#90EE90
    style Login fill:#FFD700
    style Signup fill:#FFD700
```

## User Isolation (Multi-User Feature)

```mermaid
graph TB
    User1[User A] --> Token1[JWT Token A]
    User2[User B] --> Token2[JWT Token B]
    
    Token1 --> Backend[Backend API]
    Token2 --> Backend
    
    Backend --> Filter{JWT Filter}
    Filter -->|userId: 1| Data1[User A's Data Only]
    Filter -->|userId: 2| Data2[User B's Data Only]
    
    Data1 --> DB[(Database)]
    Data2 --> DB
    
    style Filter fill:#FF6B6B
    style Data1 fill:#4ECDC4
    style Data2 fill:#95E1D3
```
