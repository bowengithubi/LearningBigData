#!/bin/bash

# 启动全部大数据相关服务

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     启动Zookeeper集群     =========="
ssh hadoop102 "/opt/module/serviceManage/startZookeeper.sh"

echo "==========     启动Hadoop HA     =========="
ssh hadoop102 "/opt/module/serviceManage/startHadoopHA.sh"

echo "==========     启动Hive     =========="
ssh hadoop102 "/opt/module/serviceManage/hive.sh start"

echo "==========     启动Kafka集群     =========="
ssh hadoop102 "/opt/module/serviceManage/startKafkaCluster.sh"

echo "==========     启动Hbase集群     =========="
ssh hadoop103 "/opt/module/hbase-2.0.5/bin/start-hbase.sh"

echo "==========     项目启动结果     =========="
ssh hadoop102 "/opt/module/serviceManage/jpsall"