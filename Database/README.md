
# PostgreSQL


**Note:** we  need docker & docker-compose installed as I've pre-configured script which will do database setup for you.

Navigate to Database directory of current folder and then follow below commands to either start or stop postgres db

---

**[for Linux]**
### Spinning up Postgres db & Adminer with prerequisite
	./start.sh
### Stopping containers
	./stop.sh


---
**[for Windows]**
### Spinning up Postgres db & Adminer with prerequisite
	start.bat
### Stopping containers
	stop.bat

---
##### Files you must have in current directory
1. `docker-compose.yml`
2. `create_table.sql`
3. `insert_data.sql`
4. `start.sh`
5. `stop.sh`