## Hackathon

> Time: 48 hours

Write a server with 2 features:

1. Authenticate, use [OAuth2](https://oauth.net/2/) standard protocol with OpenID Connect and JWT token

    - Register (just need username and password)
    - Login (do not require ID token)
    - Revoke token by time

> Please note: you do not need implement full features OAuth2, just follow our requirements

2. Write an API handler a form upload file

    - A file upload field named "data" (ie, `<input type="file"/>`) that uploads
      a file that the user selects (please do not waste time trying to make the
      HTML form pretty -- we don't need HTML developers, we need Backend
      developers)

    - The form above should POST data to the `/upload` handler, which should write
      the received file data to a temporary file in /tmp.

    - Before accepting any data, you should check authorization (token generate via feature 1) is valid and the content type of the
      uploaded file is an image. If the submission is bad, please return an error. Images larger than 8
      megabytes should also be rejected.

    - Write the image metadata (content type, size, etc) to a database of your
      choice, including all relevant HTTP information.