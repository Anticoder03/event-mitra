# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased]
### Fixed
- Fixed a 500 Internal Server Error (`DataIntegrityViolationException`) that occurred when attempting to create or update a user without providing an email address.
- Added validation in `UserService` to ensure `email` is not null or blank, throwing an `IllegalArgumentException` otherwise.
- Added exception handling in `UserController` to catch `IllegalArgumentException` and return a 400 Bad Request status instead of crashing.
- Fixed a 400 Bad Request (`HttpMessageNotReadableException`) occurring when ticket creation payloads omitted the event price. Changed `Event.price` from primitive `double` to wrapper `Double`.