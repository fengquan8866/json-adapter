# json-adapter

## 功能

1. json防腐层
2. 支持接入多种json库：fastjson、gson、jackson
3. 工程中需自行引入相应json库
4. 如果要使用其它json库，需实现cn.hc.json.JsonAdapter接口

## 快速上手

1. 引入依赖

```xml

<dependency>
    <groupId>cn.hc</groupId>
    <artifactId>json-adapter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

2. 序列化

```java
Json.toJson(new User("zsf", 18));
```

3. 反序列化

```java
Json.fromJson(jsonStr, User .class);
```

4. 反序列化成集合

```java
Json.fromJsonToList(jsonStr, User .class);
```

5. 反序列化成其它自定义类型

```java
Json.fromJson(jsonStr, new TypeToken<List<User>>() {}.getType());
```