FROM postgres
ENV POSTGRES_DB banco_exemplo
ENV POSTGRES_USER usuario
ENV POSTGRES_PASSWORD 123
VOLUME ["/var/lib/postgresql/data"]

COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/