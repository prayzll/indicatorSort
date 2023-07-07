import request from '@/utils/request'

export default{
  getUserList(searchModel){
    return request({
      url: '/indicator/list',
      method: 'get',
      params:{
        pageNo: searchModel.pageNo,
        pageSize: searchModel.pageSize,
        taskName: searchModel.taskName,
      }
    });
  },
  addUser(user){
    return request({
      url: '/indicator',
      method: 'post',
      data: user
    });
  },
  updateUser(user){
    return request({
      url: '/indicator',
      method: 'put',
      data: user
    });
  },
  saveUser(user){
    if(user.taskID == null && user.taskID == undefined){
      return this.addUser(user);
    }
    return this.updateUser(user);
  },
  getUserById(id){
    return request({
      url: `/indicator/${id}`,
      method: 'get'
    });
  },
  deleteUserById(id){
    return request({
      url: `/indicator/${id}`,
      method: 'delete'
    });
  },
  // getJoin(){
  //   return request({
  //     url:"/indicator/join",
  //     method:'get'
  //   })
  // }
}