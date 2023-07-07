import request from '@/utils/request'

export default{
  getAllRoleList() {
    return request({
      url: '/indicatorall',
      method: 'get'
    });
  },
}