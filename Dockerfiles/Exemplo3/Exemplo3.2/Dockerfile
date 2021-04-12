FROM postgres
ENV POSTGRES_DB app-exemplo
ENV POSTGRES_USER usuario
ENV POSTGRES_PASSWORD 123

EXPOSE 5433

COPY create-exemplo.sql /docker-entrypoint-initdb.d/
COPY insert-exemplo.sql /docker-entrypoint-initdb.d/