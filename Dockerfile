FROM clojure
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app

# Figwheel port
EXPOSE 3449
# nrepl port
EXPOSE 7888

CMD ["lein", "figwheel"]