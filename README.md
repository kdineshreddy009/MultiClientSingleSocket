# MultiClientSingleSocket/*


Create a simplified web-server:
- It will listen and wait for incoming connections to port 8080
- Once connected, read from the socket. The form of the request is "/home/user/file.txt" (any path)
- Read the content of the requested path
- Optionally, compress the content (Zip)
- Return the (optionally compressed) content in the response to the socket
- Needs to support multiple requests concurrently
*/
