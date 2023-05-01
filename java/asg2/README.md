# Getting Started

1. In this assignment, some local setting are used.
2. You can simply use localhost for testing.
3. Current configuration:
   - Host: 192.168.10.182
   - Port: 3008

## 1. Build the maven project

## 2. Test with h2-console

[http://192.168.10.182:3008/h2-console/](http://192.168.10.182:3008/h2-console/)

## 3. Test with Curl

### get all todo

```bash
curl -i http://192.168.10.182:3008/api/todo -w "\n"
```

### get todo by ID

```bash
curl -i http://192.168.10.182:3008/api/todo/1 -w "\n"
```

### add todo (auto increment)

```bash
curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"name":"Add new one","done":0}' http://192.168.10.182:3008/api/todo
```

### update todo by ID

```bash
curl -i -X PUT -H "Content-Type: application/json" -d '{"id":1,"name":"Number 1","done":0}' http://192.168.10.182:3008/api/todo/1
```

### delete todo by ID

```bash
curl -i -X DELETE http://192.168.10.182:3008/api/todo/2
```

## 4. Test with frontend

[http://192.168.10.182:3008/index.html](http://192.168.10.182:3008/index.html)

## 5. Remards

1. The first start up will create the folder ```data``` with databse ```database.mv.db```
2. The database will load the ```schema.sql``` and ```data.sql``` by default for the first start up
3. All start up after the first start up will load all pervios data automatically
