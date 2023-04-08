# CURL

## get all todo

```bash
curl -i http://192.168.10.182:3008/api/todo -w "\n"
```

## get todo by ID

```bash
curl -i http://192.168.10.182:3008/api/todo/1 -w "\n"
```

## add todo (auto increment)

```bash
curl -i -X POST -H "Content-Type: application/json" -d '{"id":0,"name":"Add new one","done":0}' http://192.168.10.182:3008/api/todo
```

## update todo by ID

```bash
curl -i -X PUT -H "Content-Type: application/json" -d '{"id":1,"name":"Number 1","done":0}' http://192.168.10.182:3008/api/todo/1
```

## delete todo by ID

```bash
curl -i -X DELETE http://192.168.10.182:3008/api/todo/2
```
