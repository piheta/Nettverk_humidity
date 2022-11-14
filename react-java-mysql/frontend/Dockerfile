FROM node:19.0.1 AS development

WORKDIR /code

COPY package.json /code/package.json
COPY package-lock.json /code/package-lock.json

RUN npm ci
COPY . /code

ENV CI=true
ENV PORT=3000

CMD [ "npm", "start" ]
FROM development AS dev-envs
RUN apt-get update
RUN apt-get install -y git


RUN useradd -s /bin/bash -m vscode
RUN groupadd docker
RUN usermod -aG docker vscode

# install Docker tools (cli, buildx, compose)
COPY --from=gloursdocker/docker / /
CMD [ "npm", "start" ]

FROM development AS build
RUN ["npm", "run", "build"]
FROM nginx:1.13-alpine

COPY --from=build /code/build /usr/share/nginx/html