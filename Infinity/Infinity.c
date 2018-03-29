char main(void) {
	int a,b;
	scanf("%x%x",&a,&b);
	if(a+b>0x3f3f3f3f)
		printf("Yes");
	else
		printf("No");
	return 0;
}