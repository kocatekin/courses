---
marp: true
theme: skku
paginate: true
---

# CDN

---

# CDN

- CDN is short for _content delivery network_.
- Usually static files such as HTML, CSS and JS are served from CDN.
- It is geographically distributed group of servers which work together to provide fast delivery.

---

# CDN

- It increases content availability.
- It increases redundancy, reduces bandwidth costs and improves security.
- It also increases speed because people will now access servers which are close to themselves.

---

# CDN

* There is an _origin server_ and _edge servers_. Origin server contains the original versions. There are several edge servers and they are distributed around the world. 
* Generally divided into two:
  * Push CDN
  * Pull CDN

---

# Push CDN

- They receive new content whenever changes occur on the server. 
- We provide content, upload it and rewrite URLs which point to the CDN. 
- We can configure when a link expires or updates. 
- Content is uploaded **only** when it is _new_ or _changed_. This minimizes the traffic and _maximizes_ the storage.
- Good for sites with small traffic where they have content which is not frequently updated.

---

# Pull CDN

- Cache is updated based on request.
- When the client sends a request which the CDN does not have, it will pull it from the origin server and populate the cache with it, then send it to user.
- Requires less maintenance compared to Push CDN.
  - Cache updates on CDN nodes are performed based on requests from the client to the origin server.
- Good for sites with heavy traffic.

---

# Disadvantages of CDNs

- It can be expensive.
- Some countries may block the IP address of the CDN.
- If we don't have any CDN server in the user's country, the data may travel more.
  
## Widely Used
- Amazon CloudFront, Google Cloud CDN, Cloudflare CDN, Fastly

---




