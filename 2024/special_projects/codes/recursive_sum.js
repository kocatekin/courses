let sum = 0;
function recursiveSum(idx, arr){
	if(idx == arr.length) {
		return sum;
	}
	sum += arr[idx];
	idx++;
	return recursiveSum(idx, arr)
}

let a = recursiveSum(0, [1,2,3]);
console.log(a);
