# Environment Variables


When we need to store sensitive data, we are not going to store them in the program. For example, we should not store passwords, API keys, secrets in our program. Instead we store them in environment variables. It can be used with the `os` module.

```python
import os
os.environ
```

Things we see here are the system's environment variables. We can also use it like a Python dictionary:

```python
import os
os.environ['USER']
os.environ.get('USER')
#does the same thing
```

If your system does not have the USER, check the output of `os.environ` and try something else. 

## Setting environment variables

In Python, we can add them to `os.environ` object. Only strings are permitted here. Adding and updating is the same.

```python
os.environ['USER'] = 'User1' #adding sth new
os.environ['USER'] = 'User2' #updating it
```

There are several different methods to store environment variables.
1. OS Storage
2. File Storage
3. Cloud Storage
4. Universal Secret Manager Storage
5. CI/CD Storage

When we create a new environment using the terminal, it only exists for that specific session. When you close the terminal, it will terminate. In that case, we can store the environment variable in an `.env` file.

We need to state that although using environment variables is more secure compared to putting the important information (such as passwords) into the source code, if the environment is open to public, it is not much secure. Therefore, the environment should not be accessible to unauthorized users. 

If your program is going to work locally, *encryption* is a good and valuables approach. One of the advantages of using a web application is this. Everything is stored on the server, only admins have credentials to use the webserver. Others just connect and download data. 

In addition, when you are using *version control systems*, be careful not to include your `env` file in the repository. It will leak important data.

However, the best way to move forward is to store these secrets in the cloud by using external secrets storage solution such as *AWS Parameter Store*, *Azure Vault*, *HashiCorp Vault*.




