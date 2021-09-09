#!/bin/bash

# 启动Azkaban服务

# 前提：
# 1、集群之间需要配置ssh免密登录
# 2、网络名称已经修改，并且配置好host解析

echo "==========     启动Azkaban Executor   =========="
ssh hadoop102 "/opt/module/azkaban/executor/bin/azkaban-executor-start.sh"

echo "==========     启动Azkaban Web服务器  =========="
ssh hadoop102 "/opt/module/azkaban/server/bin/azkaban-web-start.sh"
