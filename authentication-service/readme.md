Call:

http://localhost:9999/uaa/oauth/authorize?response_type=token&client_id=acme&redirect_uri=http://example.com&scope=openid&state=48532

Res:
http://example.com/#access_token=cc948f9f-72fa-41c0-87ac-3616d40e1fc2&token_type=bearer&state=48532&expires_in=42762

And then:
http://localhost:4444/users -H "Authorization: Bearer cc948f9f-72fa-41c0-87ac-3616d40e1fc2"
