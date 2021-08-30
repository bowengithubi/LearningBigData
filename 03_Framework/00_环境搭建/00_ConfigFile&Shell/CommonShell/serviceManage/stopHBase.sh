#!/bin/bash

# 停止HBase服务

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     停止Phoenix QueryServer  =========="
ssh hadoop102 "/opt/module/phoenix/bin/queryserver.py stop"

echo "==========     停止Hbase集群     =========="
ssh hadoop103 "/opt/module/hbase-2.0.5/bin/stop-hbase.sh"