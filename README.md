# MultiClientSingleSocket:

Create a simplified web-server:
- It will listen and wait for incoming connections to port 8080
- Once connected, read from the socket. The form of the request is "/home/user/file.txt" (any path)
- Read the content of the requested path
- Optionally, compress the content (Zip)
- Return the (optionally compressed) content in the response to the socket
- Needs to support multiple requests concurrently



# How to run & test:

- Pull this to local with command line(assuming you have git command-line utility installed) 

        git clone https://github.com/kdineshreddy009/MultiClientSingleSocket.git 
        
- Open eclipse IDE, 

        File -> click on "Import projects from file system & choose this directory"
        
- Navigate to src folder in this project
- right click on "Server.java" & run it as Java Application & then only do run "Client.java"
   - (if your console seems to be stuck, enter something- it should pop up)
- Like wise you run Client.java multiple times to open multiple client to same socket connections
- Then input file with complete path as input in Client.java window & click on Enter(do similarly for other Client consoles as well)
- You can observe output in Server.java console window(with path,where output zip files are saved).
