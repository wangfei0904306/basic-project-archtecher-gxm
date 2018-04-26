FROM rg.guoxiaomei.cn:5000/op/jdk8:latest

ENV TIME_ZONE Asia/Shanghai
RUN apk add --no-cache tzdata \  
&&  ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime \ 
&&  echo "${TIME_ZONE}" > /etc/timezone

RUN mkdir -p /accounting/target/

ADD ./assembly/target/attach-assemble-1.0.0.jar  /accounting/target/

COPY ./run.sh /accounting/target

RUN chmod +x /accounting/target/run.sh

WORKDIR /accounting/target/

LABEL grpc_service_7600="proto.crmapi.ReportService proto.crmapi.ExportService proto.crmapi.ScopeService"

EXPOSE 7600
EXPOSE 7610

CMD ["sh","/accounting/target/run.sh"]