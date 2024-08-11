# Chain of Responsibility Pattern Example

This project demonstrates the Chain of Responsibility design pattern. It allows multiple handler objects to process a request without needing to know which object will handle the request. This pattern is particularly useful for building a chain of checks or validations in a flexible manner.

## Overview

In this example, we simulate a server that processes login requests. The login process involves several checks that are linked together in a chain:

1. **ThrottlingMiddleware**: Limits the number of requests per minute to prevent abuse.
2. **UserExistsMiddleware**: Checks whether the user exists and whether the provided password is correct.
3. **RoleCheckMiddleware**: Checks the user's role and prints a greeting based on their role.

## Components

### Middleware

`Middleware` is an abstract class that defines the basic structure of the middleware chain. It provides a mechanism to build a chain of middleware objects and pass the request through the chain.

```java
public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
